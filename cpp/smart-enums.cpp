#include <iostream>
#include <regex>
#include <fstream>

class SmartEnum
{
};

int main(int argc, char** argv)
{
    std::cout << "Welcome to smart enums !" << std::endl;

    std::ifstream infile("../src/main/resources/enum.txt");

    std::string line;

    std::cout << "OK0" << std::endl;
    std::regex regexLine1(" \t*");
    std::cout << "OK1" << std::endl;
    std::regex regexLine2("[:alnum:]");
    std::cout << "OK2" << std::endl;
    std::regex regexLine3("[ \t]*([0-9]+)[ \t]*:");
    std::cout << "OK3" << std::endl;
    std::regex regexLine4("[ \t]*([0-9]+)[ \t]*:[ \t]*(\"[^\"]*\"");
    std::cout << "OK4" << std::endl;
    std::regex regexLine5("[ \t]*([0-9]+)[ \t]*:[ \t]*(\"[^\"]*\")[ \t]*(.*)");
    std::cout << "OK5" << std::endl;
    
    std::regex regexLine("[ \t]*([0-9]+)[ \t]*:[ \t]*(\"[^\"]*\")[ \t]*(.*)");
    std::regex regexAliases(",[ \t]*(\"[^\"]*\")[ \t]*");

    while (std::getline(infile, line))
    {
        std::istringstream iss(line);
        std::cout << "read line : " << line << std::endl;

        if (std::regex_match(line, regexLine))
        {
            std::cout << "MATCH" << std::endl;
        }
        else
        {
            std::cout << "NO MATCH" << std::endl;
        }
    }
#if 0
    std::cmatch cm; // same as std::match_results<const char*> cm;
    std::regex_match(cstr, cm, e);
    std::cout << "string literal with " << cm.size() << " matches\n";

    std::smatch sm; // same as std::match_results<string::const_iterator> sm;
    std::regex_match(line, sm, e);
    std::cout << "string object with " << sm.size() << " matches\n";

    std::regex_match(s.cbegin(), s.cend(), sm, e);
    std::cout << "range with " << sm.size() << " matches\n";

    // using explicit flags:
    std::regex_match(cstr, cm, e, std::regex_constants::match_default);

    std::cout << "the matches were: ";
    for (unsigned i = 0; i < cm.size(); ++i)
    {
        std::cout << "[" << cm[i] << "] ";
    }

    std::cout << std::endl;
#endif

    return 0;
}
