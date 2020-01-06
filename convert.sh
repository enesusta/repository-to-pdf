#!/bin/bash

create() {
    xelatex $1
}

clean() {
    rm *.log
    rm *.aux
    rm *.tex
}	

printf "%s\n\n" "$(cat <src/ascii)"

languages='Java JavaScript Bash C'
choice=0

PS3='What is the language of your source code ? : '

select language in $languages
do
    choice=$language
    break
done

echo $choice

read -p 'The name of output file: ' name

shopt -s globstar

case $choice in
    Bash)
        cat < src/bash.tex > "$name.tex"
        for i in **/*.sh;
        do
            if [ -f "$i" ]; then
                printf "Filename: %s\n" "${i##*/}"
				printf "\n %s \n" "\\pagebreak" >> "$name.tex"
                printf "%s %s\n %s\n %s\n" "\\begin{lstlisting}[,caption={" "${i##*/}}]" "$(<$i)" "\\end{lstlisting}" >> "$name.tex"
            fi
        done
        echo "\\end{document}" >> "$name.tex"
        create "$name.tex"
    ;;
    Java)
        cat < src/java.tex > "$name.tex"
        for i in **/*.java;
        do
            if [ -f "$i" ]; then
                printf "Filename: %s\n" "${i##*/}"
		printf "\n %s \n" "\\pagebreak" >> "$name.tex"
                printf "%s %s\n %s\n %s\n" "\\begin{lstlisting}[,caption={" "${i##*/}}]" "$(<$i)" "\\end{lstlisting}" >> "$name.tex"
            fi
        done
        echo "\\end{document}" >> "$name.tex"
        create "$name.tex"
	clean
    ;;
    JavaScript)
        cat < src/javascript.tex > "$name.tex"
        for i in **/*.js;
        do
            if [ -f "$i" ]; then
                printf "Filename: %s\n" "${i##*/}"
				printf "\n %s \n" "\\pagebreak" >> "$name.tex"
                printf "%s %s\n %s\n %s\n" "\\begin{lstlisting}[,caption={" "${i##*/}}]" "$(<$i)" "\\end{lstlisting}" >> "$name.tex"
            fi
        done
        
        echo "\\end{document}" >> "$name.tex"
        create "$name.tex"
    ;;
    C)
        cat < src/c.tex > "$name.tex"
        for i in **/*.c;
        do
            if [ -f "$i" ]; then
                printf "Filename: %s\n" "${i##*/}"
				printf "\n %s \n" "\\pagebreak" >> "$name.tex"
                printf "%s %s\n %s\n %s\n" "\\begin{lstlisting}[,caption={" "${i##*/}}]" "$(<$i)" "\\end{lstlisting}" >> "$name.tex"
            fi
        done
        
        echo "\\end{document}" >> "$name.tex"
        create "$name.tex"
    ;;
    *)
esac


