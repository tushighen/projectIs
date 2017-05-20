# projectIs

### add new Poll Request Example - localhost:8080/api/polls (POST)

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
          }
       ]
    }