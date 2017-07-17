NOTES:

I have changed the source code a little bit in order to make it easier for future extensions:

-ToughJetRequest and CrazyAirRequest now implements a common interface called FlightSupplierRequest, which defines a method "Object[] getMandatoryArguments()", for defining the arguments in an HTTP call to the supplier. This allows me to make a generic solution when designing the layer that is in charge of call the flight suppliers web services.
For a better understanding, you can check the FlightSupplierConnector class.

-CrazyAirResponse and ToughJetResponse now also implements a common interface, called FlightSupplierResponse, to implement the Visitor pattern along with the FlightSupplierResponseVisitor interface. This allow us to treat all response in common way, and by using polymorphism it allow us to extend the number of suppliers in an easy way. You can see for example the FlightSupplierResponseTransformer class, which transform the FlightSupplierResponses into BusyFlightsResponses.

-I could have use a Visitor pattern for the FlightSupplierRequests as well, but in my own personal experience, it won't be necessary to perform several operations on the requests, so it wasn't worth it, right now we just have to add the "Object[] getMandatoryArguments()" implementation in each concrete request class.
However, I used a Visitor pattern for the FlightSupplierResponses, because, again based on my own personal experience, as the application and business rules grow, we will need to perform more operations on the response, and otherwise we would have to add several methods on the concrete response classes, which I personally prefer to have on a Visitor class and in thus make a separation of responsibilities and concerns.

With these changes, it is relatively easy to add flight suppliers. We just need to create:
	-a concrete request class which implements FlightSupplierRequest
	-a concrete response class which implements FlightSupplierResponse
	-a new method for calling the new flight supplier web services
	-a new method on the FlightSupplierResponseTransformer, for transforming the new flight supplier response into a BusyFlightsResponse
	-a new method on the BusyFlightsRequestTransformer, for transforming the BusyFlightsRequest into the new flight supplier request

I have also added validation annotations to BusyFlightsRequest to perform a validation with the URL parameters, and to CrazyAirRequest and ToughJetRequest, to perform validations before making the http call, as well as I added validation annotations to CrazyAirResponse and ToughJetResponse to perform validations on the responses retrieved from the flight suppliers (needed based on my own experience).
And have change the datatype from String to LocalDate in the requests for the "departureDate" and "returnDate" properties, to make easier the validation.

Things to be done:

There are a couple of things remaining that needs to be done, but I'm already working 90' as the assignment says, so I didn't complete them:
	-Test the application

After you run the application, you can check it on http://localhost:8080/busyflights/flights?origin=BUE&destination=MIA&departureDate=2017-07-08&returnDate=2017-07-09&numberOfPassengers=3


ASSIGNMENT:

**Travix - Problem to be solved**

**Background:**

BusyFlights is a flights search solution which aggregates flight results initially from 2 different suppliers (CrazyAir and ToughJet). A future iteration (not part of the test) may add more suppliers.

**Recommended duration of test:**

Allocate no more than 90 minutes to complete this exercise. An incomplete solution is acceptable but documenting any remaining tasks and next steps is expected. 

**What is required:**

Use this GitHub repository as a base to implement the Busy Flights service that should produce an aggregated result from both CrazyAir and ToughJet.
The result should be a JSON response which contains a list of flights ordered by fare which has the following attributes:

**Busy Flights API**

**Request**

| Name | Description |
| ------ | ------ |
| origin | 3 letter IATA code(eg. LHR, AMS) |
| destination | 3 letter IATA code(eg. LHR, AMS) |
| departureDate | ISO_LOCAL_DATE format |
| returnDate | ISO_LOCAL_DATE format |
| numberOfPassengers | Maximum 4 passengers |

**Response**

| Name | Description |
| ------ | ------ |
| airline | Name of Airline |
| supplier | Eg: CrazyAir or ToughJet |
| fare | Total price rounded to 2 decimals |
| departureAirportCode | 3 letter IATA code(eg. LHR, AMS) |
| destinationAirportCode | 3 letter IATA code(eg. LHR, AMS) |
| departureDate | ISO_DATE_TIME format |
| arrivalDate | ISO_DATE_TIME format |

The service should connect to the both the suppliers using HTTP.

**CrazyAir API**

**Request**

| Name | Description |
| ------ | ------ |
| origin | 3 letter IATA code(eg. LHR, AMS) |
| destination | 3 letter IATA code(eg. LHR, AMS) |
| departureDate | ISO_LOCAL_DATE format |
| returnDate | ISO_LOCAL_DATE format |
| passengerCount | Number of passengers |

**Response**


| Name | Description |
| ------ | ------ |
| airline | Name of the airline |
| price | Total price |
| cabinclass | E for Economy and B for Business |
| departureAirportCode | Eg: LHR |
| destinationAirportCode | Eg: LHR |
| departureDate | ISO_LOCAL_DATE_TIME format |
| arrivalDate | ISO_LOCAL_DATE_TIME format |

**ToughJet API**

**Request**

| Name | Description |
| ------ | ------ |
| from | 3 letter IATA code(eg. LHR, AMS) |
| to | 3 letter IATA code(eg. LHR, AMS) |
| outboundDate |ISO_LOCAL_DATE format |
| inboundDate | ISO_LOCAL_DATE format |
| numberOfAdults | Number of passengers |

**Response**

| Name | Description |
| ------ | ------ |
| carrier | Name of the Airline |
| basePrice | Price without tax(doesn't include discount) |
| tax | Tax which needs to be charged along with the price |
| discount | Discount which needs to be applied on the price(in percentage) |
| departureAirportName | 3 letter IATA code(eg. LHR, AMS) |
| arrivalAirportName | 3 letter IATA code(eg. LHR, AMS) |
| outboundDateTime | ISO_INSTANT format |
| inboundDateTime | ISO_INSTANT format |

**What you need to provide:**

- A solution that meets the above requirements.
- The implementation should be made as close to 'production ready' as possible within the time constraints.

It is fine to change any of the supplied application code, if you choose to do so please add comments to indicate what has changed and why.

**Note**

Please clone this project then create your own repository from it. Do not fork/branch this project when creating your solution as it will be visible to other applicants.