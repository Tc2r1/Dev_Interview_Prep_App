//
//  ViewController.swift
//  Quizzler-iOS13
//
//  Created by Angela Yu on 12/07/2019.
//  Copyright © 2019 The App Brewery. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var questionLabel: UILabel!
    @IBOutlet weak var trueButton: UIButton!
    @IBOutlet weak var falseButton: UIButton!
    @IBOutlet weak var progressBar: UIProgressView!
    @IBOutlet weak var scoreLabel: UILabel!
    
    //declaring and initializing variables
    var currentProgress : Int = 0
    var quizBrain : QuizBrain = QuizBrain()
    var score : Int = 0
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        progressBar.progress = 0
        scoreLabel.text = "Score : \(score)"
        updateUI()
    }
    
    //function to invoke on button press
    @IBAction func buttonClick(_ sender: UIButton) {
        
        quizBrain.getNextQuestion()
        let selectedValue = sender.currentTitle!
        let isCorrect = quizBrain.getAnswer(selectedValue)
        if isCorrect {
            sender.backgroundColor = UIColor.green
        }else{
            sender.backgroundColor = UIColor.red
        }
        DispatchQueue.main.asyncAfter(deadline: .now() + 0.2, execute: {
            sender.backgroundColor = UIColor.clear
        })
        updateUI()
    }
    
    //function to Update the UI
    func updateUI(){

        progressBar.progress = quizBrain.getProgress()
        if quizBrain.questionNumber < quizBrain.questions.count {
            questionLabel.text = quizBrain.getQuestion()
        }
        scoreLabel.text = "Score : \(quizBrain.getScore())"
    }
    
}

