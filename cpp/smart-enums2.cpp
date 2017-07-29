#include <iostream>
#include <map>
#include <unordered_map>
#include <exception>


//template <typename C, typename T, T nullvalue>
class SmartEnum
{
  private:

  using Value = int;
  using Name = std::string;

  using Value2Name = std::map<Value, std::ref<SmartEnum>>;
  using Name2Value = std::unordered_map<Name, std::ref<SmartEnum>>;

  class Pair
  {
    Value value;
    const Name& name;
  };

  bool duplicateValues;
  bool duplicateNames;

  Value value;
  const Name& name;

  protected:

  static Value2Name& value2name()
  {
    static Value2Name _value2name;
    return _value2name;
  }

  static Name2Value& name2value()
  {
    static Name2Value _name2value;
    return _name2value;
  }

  static void registerPair(int value, const std::string& name)
  {
    SmartEnum smartEnum = new SmartEnum(value, name);

    auto itv = value2name().find(value);
    auto itn = name2value().find(name);

    if(itv != value2name().end() && ! duplicateValues)
    {
      throw std::exception("duplicate values are not allowed");
    }

    if(itn != name2value().end() && ! duplicateNames)
    {
      throw std::exception("duplicate names are not allowed");
    }

    value2name().insert(std::make_pair(value, smartEnum));

    name2value().insert(std::make_pair(name, smartEnum));
  }

  public:

  // getEnumOrThrow
  // getEnumOrDefault (can be none)
  // getEnumOrNone

  int getValue() const noexcept
  {
    return value;
  }

  const std::string& getName() const noexcept
  {
    return name;
  }

  static const SmartEnum ONE("one", 1);
  static const SmartEnum ONE("two", 2);
  static const SmartEnum ONE("three", 3);

  static const SmartEnum& fromValue(const T& value)
  {
  }

  static const SmartEnum& fromValue(const std::string& value)
  {
  }

  static const SmartEnum& fromValue(const char * value)
  {
  }

  static const SmartEnum& fromName(const std::string& name)
  {
  }

  static const SmartEnum& fromName(const char * name);
  {
  }
};


class SmartEnum
{
};

class UniqueValuePerName
{
};

class UniqueNamePerValue
{
};

class NoConstraint
{
};

// bijection

// injection

// surjection

// unique name

// unique value

// unknown value

// exception

class MySmartEnum : SmartEnum
{
  MySmartEnum()
  {
    // load from file
    registerPair();
    registerPair();
    registerPair();
    registerPair();
    registerPair();
    registerPair();
    registerPair();
  }
};

