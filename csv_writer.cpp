#include <iostream>
#include <fstream>
#include <utility>
#include <iterator>
#include <string>
#include <algorithm>
#include <set>
#include <vector>

class CSVWriter {
    std::string filename;
    std::string delimeter;
    int linesCount;

public:
    explicit CSVWriter(std::string filename, std::string delm = ","):
            filename(std::move(filename)), delimeter(std::move(delm)), linesCount(0) {}

            template <typename T>
            void addDataInRow(T first, T last);
};


template <typename T>
void CSVWriter::addDataInRow(T first, T last) {
    std::fstream file;
    file.open(filename, std::ios::out | (linesCount ? std::ios::app : std::ios::trunc));
    for (; first != last; ) {
        file << *first;
        if (++first != last)
            file << delimeter;
    }
    file << "\n";
    linesCount++;

    file.close();
}


int main() {
    // Creating an object of CSVWriter
    CSVWriter writer("example.csv");

    std::vector<std::string> dataList_1 = { "20", "hi", "99" };

    // Adding vector to CSV File
    writer.addDataInRow(dataList_1.begin(), dataList_1.end());

    // Create a set of integers
    std::set<int> dataList_2 = { 3, 4, 5};

    // Adding Set to CSV File
    writer.addDataInRow(dataList_2.begin(), dataList_2.end());

    std::string str = "abc";

    // Adding characters in a string in csv file.
    writer.addDataInRow(str.begin(), str.end());

    // An array of int
    int arr [] = {3,4,1};

    // Wrote an elements in array to csv file.
    writer.addDataInRow(arr , arr + sizeof(arr) / sizeof(int));

    return 0;
}
