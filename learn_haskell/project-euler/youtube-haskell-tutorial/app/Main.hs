module Main where

import Data.List
import Lib
import System.IO

main :: IO ()
main = someFunc

-- Int: -2^63 to 2^63+1
maxInt = maxBound :: Int

-- Integer -- this is huge
-- Float -- single precision 
-- Double -- precision up to eleven points
bigFloat = 3.99999999999 + 0.00000000005
