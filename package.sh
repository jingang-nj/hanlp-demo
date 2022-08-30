#!/bin/bash

app=${1}

mvn --quiet -B -U clean package -Dmaven.test.skip=true
mv target/${app}.jar docker