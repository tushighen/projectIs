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
    
## _remove User Request Example - localhost:8080/api/users{id} (method = DELETE)_
    
    localhost:8080/api/users/1


## _add new Poll Request Example - localhost:8080/api/polls (method = POST)_

    {  
       "pollName":"New Poll",
       "createdDate":2017-03   -03,
       "modifiedDate":null,
       "active":true,
       "user":{  
          "userId":1
       },
       "userRoleId":[  
          1,
          2,
          3
       ],
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