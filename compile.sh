clear
cd src
echo "Creating temporary file with all *.java files..."
find -name "*.java" > sources.txt
echo "DONE"
echo "Compiling code"
javac @sources.txt -d ../bin -Xlint:unchecked
echo "DONE"
echo "Removing temporary files"
rm sources.txt
echo "DONE"