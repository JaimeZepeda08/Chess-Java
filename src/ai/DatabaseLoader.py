import pandas as pd
import numpy as np
import os

# games.csv from Kaggle

# Load csv file
chess_df = pd.read_csv("/Users/jaime/Documents/CS/Java/Projects/Chess/src/ai/games.csv")

# Keep only the columns `winner` and `moves`
chess_df = chess_df[["winner", "moves"]]

# Keep only the games where the black (ai) player wins
chess_df = chess_df.loc[chess_df["winner"] == "black"]

# Save the csv
chess_df.to_csv("/Users/jaime/Documents/CS/Java/Projects/Chess/src/ai/games_modified.csv", index=False)
