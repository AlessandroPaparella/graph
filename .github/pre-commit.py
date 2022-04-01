#!/usr/bin/python

import subprocess

# Hard-Coded for your repo (ToDo: get from remote?)
GITHUB_USER="AlessandroPaparella"
REPO="graph"

print("Starting pre-commit hook...")

BRANCH=subprocess.check_output(["git",
                                "rev-parse",
                                "--abbrev-ref",
                                "HEAD"]).strip().decode('utf-8')

# String with hard-coded values
# See Embedding Status Images[3] for alternate formats (private repos, svg, etc)

# Output String with Variable substitution

maven="# Graph ![Build Status](https://github.com/" \
       "{GITHUB_USER}/{REPO}/actions/workflows/maven.yml/badge.svg?" \
       "branch={BRANCH})\n".format(BRANCH=BRANCH,
                                            GITHUB_USER=GITHUB_USER,
                                            REPO=REPO)

sentinel_str="![Build Status]"

readmelines=open("README.md").readlines()
with open("README.md", "w") as fh:
    for aline in readmelines:
        if sentinel_str in aline and maven != aline:
            fh.write(maven)
        else:
            fh.write(aline)

subprocess.check_output(["git", "add", "README.md" ])

print("pre-commit hook complete.")
