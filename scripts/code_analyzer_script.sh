cd sourcecodeanalyzer
java -jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local produced_results csv
if git diff produced_results.csv correct_results.csv; then
echo "The produced results are correct!"
fi
