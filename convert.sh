#!/bin/bash

echo "Output file name: "
read name

cat < src/template.tex > "$name.tex"

shopt -s globstar

for i in **/*.java;
do	
	if [ -f "$i" ]; then
	printf "Filename: %s\n" "${i##*/}"
	printf "Path: %s\n" "`readlink -f $i`"
	printf "%s\n %s\n %s\n" "\\begin{lstlisting}[,caption={}]" "$(<$i)" "\\end{lstlisting}" >> "$name.tex"
	fi
done

echo "\\end{document}" >> "$name.tex"


pdflatex "$name.tex"
