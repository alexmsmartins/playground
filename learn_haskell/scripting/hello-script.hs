#!/usr/bin/env stack
-- stack --resolver lts-13.15 --install-ghc runghc
import Data.Char
import Data.List
import qualified Data.Map.Strict as M
import qualified Data.Text as T
import qualified Data.Text.IO as T
import System.Environment

main = do
  [fp] <- getArgs
  text <- T.readFile fp
  let histo =
        foldl'
          (\hash line -> M.insertWith (+) (T.length line) 1 hash)
          M.empty
          (T.lines text)
  mapM_ (\(key, value) -> print (key, value)) (M.toList histo)
  putStrLn "Hello"
