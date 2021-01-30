module Main where

import Data.List

import Lib

main :: IO ()
main = someFunc

multiples :: Int -> [Int]
multiples n = [x * n | x <- [1,2 ..]]

multiplesUpTo :: Int -> Int -> [Int]
multiplesUpTo n lim = [x | x <- (multiples n), x <= lim]


# 3 Functions
 add                     :: Integer -> Integer -> Integer
add x y                 =  x + y
mymap :: (a -> b) -> [a] -> [b]
mymap f [] = []
mymap f (x:xs) = f x : map f xs

-- this helped explore how to declare an infix operator
(+++) :: [a] -> [a] -> [a]
(+++) = \a b -> b ++ a



-- function composition 
-- f.g = f(g(x))
(.) :: (a -> b) -> (c -> a) -> c -> b
f . g = \ x -> f(g x)

-- (x+) = \y -> x+y

-- 

