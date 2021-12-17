cd src
echo "Criando arquivo com todos os arquivos .java"
find -name "*.java" > sources.txt
echo "Compilando todos os arquivos"
javac @sources.txt -d ../bin -Xlint:unchecked
echo "Removendo arquivos temporarios"
rm sources.txt
cd ..
echo "Rodando o código"
cd bin