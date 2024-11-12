#!/bin/zsh

url=$1 # https://leetcode.com/problems/contains-duplicate-ii/...
lang=$2 # js, kt, ...

if [[ $url =~ ^https?://leetcode.com/problems/([^/]+) ]]; then
    probName=${match[1]}
    dirPath="src/leetcode_${probName//-/_}"
    case $lang in
        "js")
        fileName="solution.js"
        ;;
        *)
        echo 'Unknown language argument.'
        ;;
    esac
    filePath="${dirPath}/${fileName}"
    mkdir -p $dirPath && touch $filePath
    echo "Solution file created at: ${filePath}"
else
    echo "Invalid URL"
fi