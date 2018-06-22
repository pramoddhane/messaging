Friend Management Api


Application with a need to build its own social network, "Friends Management" is a common requirement which usually starts off simple but can grow in complexity depending on the application's use case. 
Usually, applications would start with features like "Friend", "Unfriend", "Block", "Receive Updates" etc. 

List of REST Endpoints and ExplanationReturns a list of friends of a person.

Path : /createFriendConnection

Input :
{
"friends":
[
"pdhane@example.com",
"avi@example.com"
]
}

Sample Output :

{ "success": true }

Defined Errors : Please insert two email Ids 
Invalid Email Id


Path : /getFriendsList

Input :
{
"email": "avi@example.com"
}

Output :
{
    "count": 1,
    "frndList": [
        "pdhane@example.com"
    ],
    "success": true
}

Defined Errors : for invalid Email - No Friend List available
Invalid Email ID

Path : /getCommonFriendsList
Input :
{
"friends":
[
"andy@example.com",
"john@example.com"
]
}

Output :
{
    "success": "true",
    "count": 2,
    "friends": [
        "common@example.com",
        "common2@example.com"
    ]
}

Path : /getUpdates

Input :

{
"sender": "john@example.com",
"text": "Hello World! kate@example.com"
}

Output :

{
 "success": true
}

Path : /subscribeToUpdates

Input :

{
"requestor": "lisa@example.com",
"target": "john@example.com"
}

Output :

{
 "success": true
}

Path : /blockUpdates

Input :

{
"requestor": "lisa@example.com",
"target": "john@example.com"
}

Output :

{
    "success": "true"
}
