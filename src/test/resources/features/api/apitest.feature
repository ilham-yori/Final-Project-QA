Feature: API CRUD Test

  Scenario: Complete User CRUD Cycle
    Given base API URL "https://dummyapi.io/data/v1/"
    And authentication using app-id token

    # 1. POST (Create User)
    When I send a POST request to create a new user with body:
      """
       {
        "title": "mr",
        "firstName": "Ilham",
        "lastName": "Yori",
        "picture": "https://randomuser.me/api/portraits/med/men/29.jpg",
        "gender": "male",
        "email": "ilham.terbaru29@example.com",
        "dateOfBirth": "1999-10-14T14:44:52.955Z",
        "phone": "1234-879-2454",
        "location": {
             "street": "7531, Washington",
             "city": "Bluetown",
             "state": "United State",
             "country": "Washington",
             "timezone": "+6:00"
        }
      }

      """
    Then the API response status code should be 200
    And the response field "firstName" should be "Ilham"

    # 2. GET (Read User)
    When I send a GET request to the endpoint to get all of the users list
    Then the API response status code should be 200

    # 3. PUT (Update User)
    When I send a PUT request for id "60d0fe4f5311236168a10a1c" with body:
      """
      {
        "title": "miss",
        "firstName": "Abigail",
        "lastName": "Liu Feng",
        "picture": "https://randomuser.me/api/portraits/med/women/15.jpg",
        "gender": "female",
        "email": "madison.ambrose@example.com",
        "dateOfBirth": "1947-04-14T14:44:52.955Z",
        "phone": "756-040-5467",
        "location": {
            "street": "4122, Stanley Way",
            "city": "Cornwall",
            "state": "British Columbia",
            "country": "Canada",
            "timezone": "+6:00"
        }
      }
      """
    Then the API response status code should be 200
    And the response field "lastName" should be "Liu Feng"

    # 4. GET (all tags)
    When I send a GET request to the endpoint to get all of the tags
    Then the API response status code should be 200

    # 5. DELETE (Delete User)
    When I send a delete request for id "6a53c5ac5a85beaded691866"
    Then the API response status code should be 200
    And the response should return the correct deleted user ID