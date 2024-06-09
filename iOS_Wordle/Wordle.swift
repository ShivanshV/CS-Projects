//
//  Wordle.swift
//  Wordle
//
//  Created by Vaidhyanathan, Shivansh on 3/25/24.
//

import Foundation

struct Wordle
{
    var dictionary: [String] = []
    var answer: String = ""
    var wordIndex = 0
    var guesses: [String] = []
    
    init() {
            
            let file = Bundle.main.path(forResource: "dictionary.txt", ofType: nil)
            do
            {
                let contents = try String(contentsOfFile: file!)
                let unfiltered = contents.components(separatedBy: "\n")
                dictionary = unfiltered.filter {String($0).count == 5}
                dictionary.shuffle()
                answer = dictionary.first!
            }
            catch
        {
                print("Contents could not be loaded.")
            }
        }
    
    
    func checkWord(word: String) -> Bool {
        
        
    }
}
