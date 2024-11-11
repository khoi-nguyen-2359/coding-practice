#!/bin/zsh

url=$1 # https://leetcode.com/problems/contains-duplicate-ii/...

if [[ $url =~ ^https?://leetcode.com/problems/([^/]+) ]]; then
    probName=${match[1]}
    dirPath="src/leetcode_${probName//-/_}"
    mkdir $dirPath
    echo "Problem directory ${dirPath} created."
else
    echo "Invalid URL"
fi