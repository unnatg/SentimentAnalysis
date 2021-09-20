# Sentiment Analysis
Aspect Based Sentiment Analysis
# Methodology
## Step 1: Preprocessing
        a) Sentence Segmentation - Since the sentences have been separated 
           by a dollar sign, we will separate them and store them in a 
           different array
        b) Tokenization
        c) Removal of Stop Words
        d) Stemming

## Step 2: Feature Extraction
        a) TF-IDF (Term Frequency- Inverse Document Frequency)
           - Compute the TF-IDF score of unigram, bigram and trigram.
           - Make a feature matrix
           - Split the data into training and testing. 
        b) Lexicon Based Approach
           // POS-tagger
           // Dependency Parser
           a) Compare with Hindi SentiWordNet and find the polarity
              and the POS tag as well.  

## Step 3: Sentiment Score Computation
        a) Machine Learning Algorithms
           a) SupportVectorClassifier
           b) RandomForestClassifier
           c) XGBoost
           d) LogisticRegression
           e) KNearestNeighbour
        
        b) Lexicon-Based Approach
           a) Use Hindi SentiWordNet(HSWN) to compute the Sentiment Score
           the sentence.
            