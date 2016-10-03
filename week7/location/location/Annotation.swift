//
//  Annotation.swift
//  location
//
//  Created by Aileen Pierce on 11/11/14.
//  Copyright (c) 2014 Aileen Pierce. All rights reserved.
//

import UIKit
import MapKit

class Annotation: NSObject, MKAnnotation {
    var coordinate : CLLocationCoordinate2D
    var title : String
    var subtitle : String

    override init() {
        self.coordinate={0.0; 0.0;}()
        self.title=" "
        self.subtitle=" "
    }
    
    func setAnnotation(coordinate: CLLocationCoordinate2D, title: String, subtitle: String)-> Annotation{
        self.coordinate=coordinate
        self.title=title
        self.subtitle=subtitle
        return self
    }
   
}
