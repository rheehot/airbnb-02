//
//  Request.swift
//  Airbnb
//
//  Created by kimdo2297 on 2020/05/25.
//  Copyright © 2020 Chaewan Park. All rights reserved.
//

import Foundation

enum HTTPMethod {
    case get, post, put, patch, delete
}

protocol Request {
    var path: String { get }
    var method: HTTPMethod { get }
    var body: Data? { get }
    var headers: [String: String]? { get }
    
    func urlRequest() throws -> URLRequest?
}

enum NetworkErrorCase: Error {
    case invalidURL
    case notFound
}

extension Request {
    var method: HTTPMethod { return .get }
    var body: Data? { return nil }
    var headers: [String: String]? { return nil }
    
    func urlRequest() throws -> URLRequest? {
        guard let url = URL(string: path) else { throw NetworkErrorCase.invalidURL }
        return URLRequest(url: url)
    }
}
