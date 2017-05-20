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
             "questionName":"helloWorld",
             "questionDescription":"HelloWorld 1",
             "poll":{  
                "pollId":1
             },
             "questionType":{  
                "questionTypeId":1
             },
             "optionChoices":[  
                {  
                   "choiceName":"helloworld A"
                },
                {  
                   "choiceName":"helloworld B"
                },
                {  
                   "choiceName":"helloworld c"
                },
                {  
                   "choiceName":"helloworld D"
                }
             ]
          }
       ]
    }