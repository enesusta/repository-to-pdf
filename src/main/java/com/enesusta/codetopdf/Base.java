package com.enesusta.codetopdf;

public interface Base {

    String text = "\\documentclass[a4paper,10pt]{article}\n" +
        "\n" +
        "\\usepackage{titleps}\n" +
        "\\usepackage{epstopdf}\n" +
        "\\usepackage{fancyhdr}\n" +
        "\\usepackage{graphicx}\n" +
        "\\usepackage{lipsum}\n" +
        "\\usepackage[normalem]{ulem}\n" +
        "\\usepackage[table]{xcolor}\n" +
        "\\usepackage[turkish]{babel}\n" +
        "\\usepackage[utf8]{inputenc}\n" +
        "\\usepackage{multicol}\n" +
        "\\usepackage[T1]{fontenc}\n" +
        "\\usepackage{ragged2e}\n" +
        "\\usepackage{listings}\n" +
        "\\usepackage{color}\n" +
        "\\usepackage[a4paper,bindingoffset=0.2in,%\n" +
        "            left=0.4in,right=0.4in,top=0.5in,bottom=0.5in,%\n" +
        "            footskip=.25in]{geometry}\n" +
        "\\usepackage{blindtext}\n" +
        "\\usepackage{amsmath}\n" +
        "\\usepackage{breqn}\n" +
        "\\usepackage{tabto}\n" +
        "\\usepackage{zlmtt}\n" +
        "\\usepackage{fancyvrb}\n" +
        "\n" +
        "\\pagestyle{myheadings}\n" +
        "\\pagestyle{fancy}\n" +
        "\\fancyhf{}\n" +
        "\n" +
        "\\fancyfoot[C]{\\textcopyright Enes Usta}\n" +
        "\\fancyfoot[R]{\\thepage}\n" +
        "\n" +
        "\\definecolor{dkgreen}{rgb}{0,0.6,0}\n" +
        "\\definecolor{gray}{rgb}{0.5,0.5,0.5}\n" +
        "\\definecolor{mauve}{rgb}{0.58,0,0.82}\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "\\lstset{\n" +
        "   language=Java,\n" +
        "   captionpos=t,\n" +
        "   tabsize=3,\n" +
        "   frame=single,\n" +
        "   frameround=tttt\n" +
        "   backgroundcolor=\\color{highlight},\n" +
        "   basicstyle=\\footnotesize\\ttfamily,\n" +
        "   keywordstyle=\\color{purple}\\bfseries,\n" +
        "   commentstyle=\\color{green},\n" +
        "   stringstyle=\\color{red},\n" +
        "   morecomment=[s][\\color{blue}]{/**}{*/},\n" +
        "   breaklines=true,\n" +
        "   showstringspaces=false,\n" +
        "   emph={label},\n" +
        "   inputencoding=utf8,\n" +
        "   extendedchars=true,\n" +
        "   % German umlauts\n" +
        "   literate=%\n" +
        "   {Ö}{{\\\"O}}1\n" +
        "   {Ä}{{\\\"A}}1\n" +
        "   {Ü}{{\\\"U}}1\n" +
        "   {ß}{{\\ss}}1\n" +
        "   {ü}{{\\\"u}}1\n" +
        "   {ä}{{\\\"a}}1\n" +
        "   {ö}{{\\\"o}}1\n" +
        "   %Türkçe karakterler\n" +
        "   {ı}{{\\i}}1\n" +
        "   {İ}{{\\.{I}}}1    % This is the problem character.\n" +
        "   {ğ}{{\\u{g}}}1\n" +
        "   {Ğ}{{\\u{G}}}1\n" +
        "   {ş}{{\\c{s}}}1\n" +
        "   {Ş}{{\\c{S}}}1\n" +
        "   {ç}{{\\c{c}}}1\n" +
        "   {Ç}{{\\c{C}}}1\n" +
        "}\n" +
        "\n" +
        "\\begin{document}\n";

}
