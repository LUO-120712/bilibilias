//
//  ContentView.swift
//  BILIBILIAS
//
//  Created by 萌新杰少 on 2026/5/18.
//

import SwiftUI
import UIKit
import ASShared

struct SharedSmoke {
    let started: String

    init() {
        started = "ASShared ready"
    }
}

struct ContentView: View {
    private let sharedSmoke = SharedSmoke()

    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text("BILIBILIAS")
            Text(sharedSmoke.started)
                .font(.footnote)
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
