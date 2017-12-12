# beamer-to-article
A small utility that converts beamer presentations to articles. It does so by:
 - Changing the document class to `article`
 - Removing beamer commands
 - Inserting the paper title
 - Changing each slide into a `paragraph`
 - (Optional) Removing enumerations (using `--remove-enums`)
 
 For the moment, the beamer file path is hard-coded to `presentation/presentation.tex`. A file named `presentation/presentation-article.tex` will be created if the conversion is successful.


