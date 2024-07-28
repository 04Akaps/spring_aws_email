# echo "Build Project"

# $BASE_API_DIR/gradlew clean build

# echo "Start Server"

# cd $BASE_API_DIR/build/libs
# java -jar demo-0.0.1-SNAPSHOT.jar


echo "Build Project"

./gradlew clean build

echo "Start Server"

cd ./build/libs
java -jar demo-0.0.1-SNAPSHOT.jar