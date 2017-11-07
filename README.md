# projectIS

## _Login Request Example - localhost:8080/api/users/login (method = POST)_

    {  
       "email":"example@example.com",
       "password":"example"
    }

## _add new User Request Example - localhost:8080/api/users (method = POST)_

    {  
       "email":"example@example.com",
       "userName":"username",
       "password":"password",
       "userRole":{  
          "userRoleId":1 
       }
    }
    
## _edit User Request Example - localhost:8080/api/users (method = PUT)_

    {  
       "userId": 1,
       "email":"example@example.com",
       "userName":"username",
       "password":"password",
       "userRole":{  
          "userRoleId":1 
       }
    }
    
## _request developer User Request Example - localhost:8080/api/users (method = PUT)_

    {  
       "userId": 1,
       "email":"example@example.com",
       "userName":"username",
       "password":"password",
       "userRole":{  
          "userRoleId":1 
       },
       "requested": "true"
    }
    
## _edit to developer User Request Example - localhost:8080/api/users (method = PUT)_

    {  
       "userId": 1,
       "email":"example@example.com",
       "userName":"username",
       "password":"password",
       "userRole":{  
          "userRoleId":2 
       },
       "requested": "true",
       "developer": "true"
    }
    
## _remove User Request Example - localhost:8080/api/users{id} (method = DELETE)_
    
    localhost:8080/api/users/1


## _add new Poll Request Example - localhost:8080/api/polls (method = POST)_

    {  
       "pollName":"New Poll",
       "modifiedDate":null,
       "active":true,
       "user":{  
          "userId":1
       },
       "questions":[  
          {  
             "questionName":"New Question",
             "questionDescription":"Hello this is new question",
             "poll":{  
                "pollId":1
             },
             "questionType":{  
                "questionTypeId":1
             },
             "optionChoices":[  
                {  
                   "choiceName":"option 1"
                },
                {  
                   "choiceName":"option 2"
                },
                {  
                   "choiceName":"option 3"
                },
                {  
                   "choiceName":"option 4"
                }
             ]
          },
          {  
             "questionName":"New Question 2",
             "questionDescription":"Hello this is new question 2",
             "poll":{  
                "pollId":1
             },
             "questionType":{  
                "questionTypeId":1
             },
             "optionChoices":[  
                {  
                   "choiceName":"option 1"
                },
                {  
                   "choiceName":"option 2"
                },
                {  
                   "choiceName":"option 3"
                },
                {  
                   "choiceName":"option 4"
                }
             ]
          }
       ]
    }

## _edit Poll Request Example - localhost:8080/api/polls (method = PUT)_
    
    {
            "pollId": 4,
            "pollName": "New Poll edited",
            "questions": [
                {
                    "questionId": 5,
                    "questionName": "New Question edited",
                    "questionDescription": "Hello this is new question edited",
                    "questionType":{  
                		"questionTypeId":1
            		 },
                    "optionChoices": [
                        {
                            "optionChoiceId": 9,
                            "choiceName": "option 1 edited"
                        },
                        {
                            "optionChoiceId": 10,
                            "choiceName": "option 2 edited"
                        },
                        {
                            "optionChoiceId": 11,
                            "choiceName": "option 3 edited"
                        },
                        {
                            "optionChoiceId": 12,
                            "choiceName": "option 4 edited"
                        }
                    ],
                    "type": null
                },
                {
                    "questionId": 6,
                    "questionName": "New Question 2 edited",
                    "questionDescription": "Hello this is new question 2 edited",
                    "questionType":{  
                		"questionTypeId":1
            		 },
                    "optionChoices": [
                        {
                            "optionChoiceId": 13,
                            "choiceName": "option 1 edited"
                        },
                        {
                            "optionChoiceId": 14,
                            "choiceName": "option 2 edited"
                        },
                        {
                            "optionChoiceId": 15,
                            "choiceName": "option 3 edited"
                        },
                        {
                            "optionChoiceId": 16,
                            "choiceName": "option 4 edited"
                        }
                    ],
                    "type": null
                }
            ],
            "active": true,
            "user":{  
            	"userId":1
            }
        }
        
## _remove Poll Request Example - localhost:8080/api/polls (method = DELETE)_

    localhost:8080/api/polls/1

