# practice-flights

A practice set for the lab test: the same kind of model and queries, and the **same tests** your lab
test solution will be graded with. This set has **64 queries** (the lab test has 6).

## Workflow

1. Open the project in IntelliJ IDEA, set a JDK 25 environment, and check that the *Lombok* plugin is
   enabled.
2. Create the package `flights`: the model classes and the repository, following the sheet below.
   Every method of the `base.Queries` interface must be implemented for your code to compile; a query you
   have not solved yet can simply `throw new UnsupportedOperationException();`.
3. Run the `main()` method of your repository class to check whether the JSON document can be read.

Do not modify the `base` package and the `data.json`: the grading uses the original ones.

---

#### The input

You will read a JSON document containing an array of *airport* objects.

##### The object describing an *airport*

Each object has the following properties:

1. `code`: the code of the *airport* (JSON type: `string`)
1. `city`: the city of the *airport* (JSON type: `string`)
1. `country`: the country of the *airport* (JSON type: `string`)

   This property contains one of the following values:

   1. `"Germany"`
   1. `"Spain"`
   1. `"Switzerland"`
   1. `"France"`

1. `runways`: the number of runways of the *airport* (JSON type: `number`, contains integers)
1. `flights`: the flights of the *airport* (JSON type: `array`, contains objects, each element represents a *flight*)

##### The object describing a *flight*

Each object has the following properties:

1. `number`: the flight number of the *flight* (JSON type: `string`)
1. `destination`: the destination of the *flight* (JSON type: `string`)
1. `duration`: the duration in minutes of the *flight* (JSON type: `number`, contains integers)

#### Creating the representation

Define the model classes in the package `flights` to represent the given JSON document using *Lombok*. The names of the classes and the fields are mandatory.

1. Create the class `Airport` representing an *airport*. Follow the given instructions:

   1. Guarantee that all the fields are accessible only from the same package.
   1. Prevent other classes from being derived from this class.
   1. Guarantee that the fields cannot be modified after instantiation.
   1. Field `country` must be represented as an enum constant (see the details later).
   1. Field `flights` must be represented as an array.
   1. Generate a constructor having all the parameters. Use the public visibility.
   1. Generate a constructor having no parameter. Use the private visibility.
   1. Generate a getter method for each field. Use the public visibility.
   1. Generate a `toString()` method which contains all the fields except the `flights` field.
   1. Two objects are identical if their `code` fields are the same.

1. Create the class `Airport.Flight` representing a *flight* as the public static nested class of the class `Airport`. Follow the given instructions:

   1. Make the class immutable (having the common features).
   1. Generate a constructor having all the parameters. Use the public visibility.
   1. Generate a constructor having no parameter. Use the private visibility.
   1. Generate a getter method for each field. Use the public visibility.
   1. Generate a `toString()` method which contains all the fields.
   1. Two objects are identical if their `number` fields are the same.

1. Create the enum class `Airport.Country` representing the possible values of the field `country` as the public static nested enum class of the class `Airport`.

#### Extending the `Repository` class

You got the abstract `base.Repository<T>` class that is capable of reading a JSON document using the *Jackson* library, and store the objects in the memory.

1. Define the class `AirportRepository` in the package `flights`.
1. Extend the `Repository` class as the following:

   1. provide the class `Airport` as its generic type parameter
   1. define a parameterless constructor to support the instantiation of your class

1. Test your solution as the following:

   1. you have the `data.json` sample JSON document in your `src/main/resources` folder
   1. define a `main()` method in the `AirportRepository` class
   1. instantiate a single instance of the `AirportRepository` class to check whether the sample JSON document could be read

#### Implementing the `Queries` interface

Implement the `base.Queries<T, U, V>` interface by the `AirportRepository` class, follow the documentation comments:

1. Provide the class `Airport` as the value for the parameter `T`.
1. Provide the class `Airport.Flight` as the value for the parameter `U`.
1. Provide the enum class `Airport.Country` as the value for the parameter `V`.

<div class="alert alert-info">
This is a practice sheet containing 64 queries built from the common query catalog. Each method can be solved independently.
</div>

##### Disclaimer

<div class="alert alert-info">
In this exercise sheet, ChatGPT generated the content of the sample JSON document. Thus, we do not have any responsibility for containing unreal examples.
</div>
