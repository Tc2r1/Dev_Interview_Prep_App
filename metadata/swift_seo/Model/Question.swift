import Foundation

struct  Question {
    
    //struct properties
    var question : String
    var answer : String
    
    //method to initialize the struct
    init(q : String, a : String) {
        self.question = q
        self.answer = a
    }
    
    //getter methods
    func getQuestion() -> String {
        return self.question
    }
    
    func getAnswer() -> String {
        return self.question
    }
}
