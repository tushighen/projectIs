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
    
## _edit User(Only user name) Example - localhost:8080/api/users (method = PUT)_

    {  
       "id":1,
       "email":"example@example.com",
       "userName":"example",
       "password": "",
       "currentPassword": "example"
    }
    
## _edit User(Password) Example - localhost:8080/api/users (method = PUT)_

    {  
       "id":1,
       "email":"example@example.com",
       "userName":"example",
       "password": "new password",
       "currentPassword": "example"
    }
    
## _remove User Example - localhost:8080/api/users{id} (method = DELETE)_
    
    localhost:8080/api/users/1


## _add new Poll Request Example - localhost:8080/api/polls (method = POST)_

    {  
       "pollName":"New Poll",
       "startDate":"2017-11-09",
       "endDate":"2017-11-09",
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
       "pollId":9,
       "pollName":"New Poll Edited",
       "startDate":1510185600000,
       "endDate":1510185600000,
       "user":{  
          "userId":1
       },
       "questions":[  
          {  
             "questionId":14,
             "questionName":"New Question",
             "questionDescription":"Hello this is new question",
             "questionType":{  
                "questionTypeId":1
             },
             "optionChoices":[  
                {  
                   "optionChoiceId":51,
                   "choiceName":"option 1"
                },
                {  
                   "optionChoiceId":52,
                   "choiceName":"option 2"
                },
                {  
                   "optionChoiceId":53,
                   "choiceName":"option 3"
                },
                {  
                   "optionChoiceId":54,
                   "choiceName":"option 4"
                },
                {  
                   "optionChoiceId":55,
                   "choiceName":"option 4"
                }
             ]
          },
          {  
             "questionId":15,
             "questionName":"New Question 2",
             "questionDescription":"Hello this is new question 2",
             "questionType":{  
                "questionTypeId":1
             },
             "optionChoices":[  
                {  
                   "optionChoiceId":56,
                   "choiceName":"option 1"
                },
                {  
                   "optionChoiceId":57,
                   "choiceName":"option 2"
                },
                {  
                   "optionChoiceId":58,
                   "choiceName":"option 3"
                },
                {  
                   "optionChoiceId":59,
                   "choiceName":"option 4"
                }
             ]
          }
       ]
    }
        
## _remove Poll Request Example - localhost:8080/api/polls (method = DELETE)_

    localhost:8080/api/polls/1
    
## _add Answer Example - localhost:8080/api/polls (method = DELETE)_

    {  
       "poll":{  
          "pollId":1
       },
       "user":{  
          "userId":1
       },
       "answers":[  
          {  
             "optionChoice":{  
                "optionChoiceId":1
             }
          },
          {
          	"optionChoice": {
             	"optionChoiceId": 2
             }
          },
          {
          	"optionChoice": {
             	"optionChoiceId": 0
             }
          }
       ]
    }
    
## _view PollStatistics - localhost:8080/api/polls (method = DELETE)_
    
    SELECT p.poll_id, p.poll_name, q.question_id, q.question_name, a.option_choice_id, o.choice_name, a.answer_text
      FROM answer as a
      JOIN option_choice as o ON a.option_choice_id = o.option_choice_id
      JOIN question as q ON q.question_id = o.question_id
      JOIN poll as p ON p.poll_id = q.poll_id;
