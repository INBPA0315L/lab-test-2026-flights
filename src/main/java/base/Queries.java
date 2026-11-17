package base;

import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Defines queries for your {@link Repository} implementation.
 *
 * @param <T> the type of your top-level class
 * @param <U> the type of your static nested class
 * @param <V> the type of your enumerated class
 */
public interface Queries<T, U, V extends Enum<V>> {

    /**
     * Returns the greatest count of flights of an airport.
     *
     * @return the result
     * @throws IllegalStateException if there are no <i>airports</i>
     */
    int getMaximumCountOfFlights();

    /**
     * Returns the smallest count of flights of an airport.
     *
     * @return the result
     * @throws IllegalArgumentException if there are no <i>airports</i>
     */
    int getMinimumCountOfFlights();

    /**
     * Returns the total count of flights of the airports that have the given country.
     *
     * @param country the country
     * @return the result
     */
    int getTotalCountOfFlightsFilterByCountry(
            @NonNull V country);

    /**
     * Returns the number of distinct flights (according to their equality) of all the airports.
     *
     * @return the result
     */
    int getCountOfDistinctFlights();

    /**
     * Returns the greatest number of runways of the airports.
     *
     * @return the result
     * @throws java.util.NoSuchElementException if there are no <i>airports</i>
     */
    int getMaximumOfRunways();

    /**
     * Returns the smallest number of runways of the airports.
     *
     * @return the result
     * @throws IllegalStateException if there are no <i>airports</i>
     */
    int getMinimumOfRunways();

    /**
     * Returns the average number of runways of the airports that have the given country.
     *
     * @param country the country
     * @return the result
     * @throws java.util.NoSuchElementException if no <i>airport</i> has the given country
     */
    double getAverageOfRunwaysFilterByCountry(
            @NonNull V country);

    /**
     * Returns the greatest duration in minutes of all the flights.
     *
     * @return the result
     * @throws IllegalStateException if there are no <i>flights</i>
     */
    int getMaximumOfFlightDuration();

    /**
     * Returns the average duration in minutes of the flights of the airports that have the given country.
     *
     * @param country the country
     * @return the result
     * @throws IllegalArgumentException if the <i>airports</i> having the given country have no <i>flights</i>
     */
    double getAverageOfFlightDurationFilterByCountry(
            @NonNull V country);

    /**
     * Returns the number of airports that have the given country.
     *
     * @param country the country
     * @return the result
     */
    int getCountOfAirportsFilterByCountry(
            @NonNull V country);

    /**
     * Returns the number of airports whose number of runways is greater than the given value.
     *
     * @param runways the number of runways of the airport
     * @return the result
     */
    int getCountOfAirportsAboveRunwaysLimit(
            int runways);

    /**
     * Returns the number of airports whose city starts with the given prefix (case-sensitive).
     *
     * @param prefix the prefix
     * @return the result
     */
    int getCountOfAirportsByCityPrefix(
            @NonNull String prefix);

    /**
     * Returns the number of airports that have any flight with the given destination.
     *
     * @param destination the destination of the flight
     * @return the result
     */
    int getCountOfAirportsByFlightDestination(
            @NonNull String destination);

    /**
     * Returns the number of airports that do not have any flights.
     *
     * @return the result
     */
    int getCountOfAirportsWithoutFlights();

    /**
     * Returns the number of flights (counting each occurrence) that have the given flight number.
     *
     * @param number the flight number of the flight
     * @return the result
     */
    int getCountOfFlightsByNumber(
            @NonNull String number);

    /**
     * Returns the number of distinct countries of the airports that have at least the given number of flights.
     *
     * @param count the minimal count
     * @return the result
     */
    int getCountOfDistinctCountriesFilterByCountOfFlights(
            int count);

    /**
     * Returns the number of distinct city values of the airports that have the given country.
     *
     * @param country the country
     * @return the result
     */
    int getCountOfDistinctCityValuesFilterByCountry(
            @NonNull V country);

    /**
     * Returns the sum of the number of runways of the airports that have the given country.
     *
     * @param country the country
     * @return the result
     */
    int getSumOfRunwaysFilterByCountry(
            @NonNull V country);

    /**
     * Returns the sum of the duration in minutes of the flights (counting each occurrence) that have the given destination.
     *
     * @param destination the destination of the flight
     * @return the result
     */
    int getSumOfFlightDurationByDestination(
            @NonNull String destination);

    /**
     * Returns the smallest duration in minutes of all the flights.
     *
     * @return the result
     * @throws IllegalStateException if there are no <i>flights</i>
     */
    int getMinimumOfFlightDuration();

    /**
     * Returns the average count of flights of the airports that have the given country.
     *
     * @param country the country
     * @return the result
     * @throws java.util.NoSuchElementException if no <i>airport</i> has the given country
     */
    double getAverageCountOfFlightsFilterByCountry(
            @NonNull V country);

    /**
     * Returns the greatest length of the code of the airports.
     *
     * @return the result
     * @throws java.util.NoSuchElementException if there are no <i>airports</i>
     */
    int getMaximumLengthOfCode();

    /**
     * Returns the city of the airport that has the greatest number of runways.
     * If more airports have the greatest value, the first one is considered.
     * Returns <code>null</code> if there are no <i>airports</i>.
     *
     * @return the result
     */
    String getCityOfAirportWithMaximumRunways();

    /**
     * Returns whether any airport has the given number of runways.
     *
     * @param runways the number of runways of the airport
     * @return the result
     */
    boolean isRunwaysPresent(
            int runways);

    /**
     * Returns whether any airport has any flight with the given destination.
     *
     * @param destination the destination of the flight
     * @return the result
     */
    boolean isFlightDestinationPresent(
            @NonNull String destination);

    /**
     * Returns whether every airport has at least the given number of flights.
     *
     * @param count the minimal count
     * @return the result
     */
    boolean doAllAirportsHaveAtLeastFlights(
            int count);

    /**
     * Returns the sorted copy of the airports using the {@link Comparable} interface.
     *
     * <p>
     * The stages:
     * <ol>
     *     <li> the city of the <i>airport</i> (ascending)
     *     <li> the number of runways of the <i>airport</i> (ascending)
     *     <li> the code of the <i>airport</i> (descending)
     * </ol>
     * </p>
     *
     * <p>
     * Notes:
     * <ol>
     *     <li>The method cannot modify the original list.
     *     <li>This task includes the implementation of the {@link Comparable} interface in your model class due to its nature.
     * </ol>
     * </p>
     *
     * @return the result
     */
    List<T> getAirportsOrderByCityThenByRunwaysThenByCodeDesc();

    /**
     * Returns the sorted copy of the airports using the {@link java.util.Comparator} interface.
     *
     * <p>
     * The stages:
     * <ol>
     *     <li> the city of the <i>airport</i> (ascending)
     *     <li> the number of runways of the <i>airport</i> (ascending)
     *     <li> the code of the <i>airport</i> (ascending)
     * </ol>
     * </p>
     *
     * <p>
     * Notes:
     * <ol>
     *     <li>The method cannot modify the original list.
     *     <li>The {@link java.util.Comparator} interface must be implemented as a public top-level class in its own source file.
     * </ol>
     * </p>
     *
     * @return the result
     */
    List<T> getAirportsOrderByCityThenByRunwaysThenByCode();

    /**
     * Returns the sorted copy of the airports using the {@link java.util.Comparator} interface.
     *
     * <p>
     * The stages:
     * <ol>
     *     <li> the city of the <i>airport</i> (ascending)
     *     <li> the number of runways of the <i>airport</i> (ascending)
     *     <li> the code of the <i>airport</i> (descending)
     * </ol>
     * </p>
     *
     * <p>
     * Notes:
     * <ol>
     *     <li>The method cannot modify the original list.
     *     <li>The {@link java.util.Comparator} interface must be implemented as an anonymous class inside this method (not as a lambda expression).
     * </ol>
     * </p>
     *
     * @return the result
     */
    List<T> getAirportsOrderByCityThenByRunwaysThenByCodeDesc2();

    /**
     * Returns the sorted copy of the airports using the {@link java.util.Comparator} interface.
     *
     * <p>
     * The stages:
     * <ol>
     *     <li> the number of runways of the <i>airport</i> (descending)
     *     <li> the city of the <i>airport</i> (ascending)
     *     <li> the code of the <i>airport</i> (ascending)
     * </ol>
     * </p>
     *
     * <p>
     * Notes:
     * <ol>
     *     <li>The method cannot modify the original list.
     *     <li>The {@link java.util.Comparator} interface must be implemented as a static nested class of your repository class.
     * </ol>
     * </p>
     *
     * @return the result
     */
    List<T> getAirportsOrderByRunwaysDescThenByCityThenByCode();

    /**
     * Returns the sorted copy of the airports using the {@link java.util.Comparator} interface.
     *
     * <p>
     * The stages:
     * <ol>
     *     <li> the number of runways of the <i>airport</i> (ascending)
     *     <li> the city of the <i>airport</i> (ascending)
     *     <li> the code of the <i>airport</i> (ascending)
     * </ol>
     * </p>
     *
     * <p>
     * Notes:
     * <ol>
     *     <li>The method cannot modify the original list.
     *     <li>The {@link java.util.Comparator} interface must be implemented as a static nested class of the class representing the <i>airport</i>.
     * </ol>
     * </p>
     *
     * @return the result
     */
    List<T> getAirportsOrderByRunwaysThenByCityThenByCode();

    /**
     * Returns the first airport that has the given country.
     *
     * @param country the country
     * @return the result
     * @throws java.util.NoSuchElementException if no <i>airport</i> matches the condition
     */
    T getFirstAirportByCountry(
            @NonNull V country);

    /**
     * Returns the first airport that has the given code.
     *
     * @param code the code of the airport
     * @return the result
     * @throws IllegalStateException if no <i>airport</i> matches the condition
     */
    T getFirstAirportByCode(
            @NonNull String code);

    /**
     * Returns the first airport that has any flight with the given destination.
     * Returns <code>null</code> if no <i>airport</i> matches the condition.
     *
     * @param destination the destination of the flight
     * @return the result
     */
    T getFirstAirportByFlightDestination(
            @NonNull String destination);

    /**
     * Returns the first flight that has the given flight number.
     * Returns <code>null</code> if no <i>flight</i> matches the condition.
     *
     * @param number the flight number of the flight
     * @return the result
     */
    U getFirstFlightByNumber(
            @NonNull String number);

    /**
     * Returns the airport that has the greatest number of runways.
     * If more airports have the greatest value, the first one is returned.
     *
     * @return the result
     * @throws IllegalStateException if there are no <i>airports</i>
     */
    T getAirportWithMaximumRunways();

    /**
     * Returns the airport that has the most flights.
     * If more airports have the greatest count, the first one is returned.
     * Returns <code>null</code> if there are no <i>airports</i>.
     *
     * @return the result
     */
    T getAirportWithMostFlights();

    /**
     * Returns the flight that has the greatest duration in minutes among all the flights.
     * If more flights have the greatest value, the first one is returned.
     * Returns <code>null</code> if there are no <i>flights</i>.
     *
     * @return the result
     */
    U getFlightWithMaximumDuration();

    /**
     * Returns all the airports that have the given country but do not contain the given flight.
     *
     * @param country the country
     * @param flight the flight
     * @return the result
     */
    List<T> getAirportsFilterByCountryWithoutFlight(
            @NonNull V country,
            @NonNull U flight);

    /**
     * Returns all the airports that have the given country but do not have any flight with the given flight number.
     *
     * @param country the country
     * @param number the flight number of the flight
     * @return the result
     */
    List<T> getAirportsFilterByCountryWithoutFlightNumber(
            @NonNull V country,
            @NonNull String number);

    /**
     * Returns all the airports that contain the given flight.
     *
     * @param flight the flight
     * @return the result
     */
    List<T> getAirportsContainingFlight(
            @NonNull U flight);

    /**
     * Returns all the airports whose number of runways is greater than the given value.
     *
     * @param runways the number of runways of the airport
     * @return the result
     */
    List<T> getAirportsAboveRunwaysLimit(
            int runways);

    /**
     * Returns all the airports that have at least the given number of flights.
     *
     * @param count the minimal count
     * @return the result
     */
    List<T> getAirportsFilterByCountOfFlights(
            int count);

    /**
     * Returns the flights of the airports that have the given country.
     * The result cannot contain duplicates and must keep the order of the first occurrences.
     *
     * @param country the country
     * @return the result
     */
    List<U> getDistinctFlightsInOrderFilterByCountry(
            @NonNull V country);

    /**
     * Returns all the countries that have any airport with any flight having the given destination.
     *
     * @param destination the destination of the flight
     * @return the result
     */
    Set<V> getCountriesByFlightDestination(
            @NonNull String destination);

    /**
     * Returns all the countries that have any airport containing the given flight.
     *
     * @param flight the flight
     * @return the result
     */
    Set<V> getCountriesContainingFlight(
            @NonNull U flight);

    /**
     * Returns the city of each airport that has any flight with the given destination.
     *
     * @param destination the destination of the flight
     * @return the result
     */
    Set<String> getCityValuesByFlightDestination(
            @NonNull String destination);

    /**
     * Returns all the flights of the airports that have the given country.
     *
     * @param country the country
     * @return the result
     */
    Set<U> getFlightsFilterByCountry(
            @NonNull V country);

    /**
     * Returns all the countries that have any airport whose number of runways is greater than the given value.
     *
     * @param runways the number of runways of the airport
     * @return the result
     */
    Set<V> getCountriesAboveRunwaysLimit(
            int runways);

    /**
     * Returns all the distinct duration in minutes values of the flights.
     *
     * @return the result
     */
    Set<Integer> getFlightDurationValues();

    /**
     * Returns a dictionary that maps each country to the number of corresponding airports that have at least
     * the given number of flights. The countries without such airports are not included.
     *
     * @param count the minimal count
     * @return the result
     */
    Map<V, Integer> getCountOfAirportsByCountriesFilterByCountOfFlights(
            int count);

    /**
     * Returns a dictionary that maps each city to the number of corresponding airports that have the given country.
     *
     * @param country the country
     * @return the result
     */
    Map<String, Integer> getCountOfAirportsByCityValuesFilterByCountry(
            @NonNull V country);

    /**
     * Returns a dictionary that maps each country to the average number of runways of the corresponding airports.
     *
     * @return the result
     */
    Map<V, Double> getAverageOfRunwaysByCountries();

    /**
     * Returns a dictionary that maps each country to the greatest number of runways of the corresponding airports.
     *
     * @return the result
     */
    Map<V, Integer> getMaximumOfRunwaysByCountries();

    /**
     * Returns a dictionary that maps each country to the sum of the duration in minutes of the flights of the corresponding airports.
     *
     * @return the result
     */
    Map<V, Integer> getSumOfFlightDurationByCountries();

    /**
     * Returns a dictionary that maps each country to the flights of the corresponding airports.
     *
     * @return the result
     */
    Map<V, Set<U>> getFlightsByCountries();

    /**
     * Returns a dictionary that maps each country to the list of corresponding airports that have at least
     * the given number of flights, in their original order. The countries without such airports are not included.
     *
     * @param count the minimal count
     * @return the result
     */
    Map<V, List<T>> getAirportsByCountriesFilterByCountOfFlights(
            int count);

    /**
     * Returns a dictionary that maps each country to the set of city values of the corresponding airports
     * whose number of runways is greater than the given value. The countries without such airports are not included.
     *
     * @param runways the number of runways of the airport
     * @return the result
     */
    Map<V, Set<String>> getCityValuesByCountriesFilterByRunways(
            int runways);

    /**
     * Returns a dictionary that maps each city of the airports having the given country to the set of
     * duration in minutes values of the flights of the corresponding airports.
     *
     * @param country the country
     * @return the result
     */
    Map<String, Set<Integer>> getDurationValuesOfFlightsByCityFilterByCountry(
            @NonNull V country);

    /**
     * Returns a dictionary that maps each duration in minutes of the flights to the set of countries of the airports
     * that have such flight and at least the given number of flights.
     *
     * @param count the minimal count
     * @return the result
     */
    Map<Integer, Set<V>> getCountriesByFlightDurationFilterByCountOfFlights(
            int count);

    /**
     * Returns a dictionary that maps each country to a dictionary that maps each number of runways of the corresponding
     * airports to the number of airports having that country and number of runways.
     *
     * @return the result
     */
    Map<V, Map<Integer, Integer>> getCountOfAirportsByCountriesAndRunways();

    /**
     * Returns a dictionary that maps each city to a dictionary that maps each country to the number of
     * airports having that city and country.
     * Only the airports with at least the given number of flights are taken into account.
     *
     * @param count the minimal count
     * @return the result
     */
    Map<String, Map<V, Integer>> getCountOfAirportsByCityAndCountriesFilterByCountOfFlights(
            int count);

    /**
     * Returns a dictionary that maps each country to a dictionary that maps each duration in minutes of the flights of the
     * corresponding airports to the number of such flights.
     *
     * @return the result
     */
    Map<V, Map<Integer, Integer>> getCountOfFlightsByCountriesAndDuration();

    /**
     * Returns a dictionary that maps each country to a dictionary that maps each city of the corresponding
     * airports to the greatest number of runways of the airports having that country and city.
     *
     * @return the result
     */
    Map<V, Map<String, Integer>> getMaximumOfRunwaysByCountriesAndCity();
}
