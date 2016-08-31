//
//  ViewController.swift
//  daVinci
//
//  Created by Aileen Pierce on 8/24/16.
//  Copyright © 2016 Aileen Pierce. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var artImage: UIImageView!
    
    @IBAction func chooseArt(sender: UIButton) {
        if sender.currentTitle=="Paintings" {
            artImage.image=UIImage(named: "MonaLisa.png")
        }
        else if sender.currentTitle=="Drawings" {
            artImage.image=UIImage(named: "Vitruvian.png")
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

