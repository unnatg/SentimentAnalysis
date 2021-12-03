package ML;

public class LogisticRegression {
    double[][] weights, bias;
    int iterations;
    double learningRate;

    LogisticRegression(double learningRate, int iterations) {
        this.learningRate = learningRate;
        this.iterations = iterations;
        this.weights = null;
        this.bias = null;
    }

    private double[] LinearModelMultiplication(double[][] X, double[][] weights, double[][] bias) {
        if (X[0].length != weights.length) {
            System.out.println("Matrix Multiplication is not possible.");
            System.exit(0);
            return null;
        }
        double[][] linear_model = new double[X.length][0];

        return null;
    }

    private void fit(double[][] X, double[] y) {
        int n_samples = X.length;
        int n_features = X[0].length;
        weights = new double[n_features][0];
        bias = new double[n_features][0];
        for (int ignored = 0; ignored < this.iterations; ignored++) {
            double[] linear_model = LinearModelMultiplication(X, this.weights, this.bias);
        }
    }

    public static void main(String[] args) {
        LogisticRegression lr = new LogisticRegression(0.01, 100);
    }
}