setwd('working directory')
df <- read.csv('data.csv',header=T)
df

Y <- df[,4]
X1 <- df[,5]
X2 <- df[,6]
X3 <- df[,7]

Full_model <- lm(Y ~ X1 + X2 + X3)
summary(Full_model)

Reduced_model <- lm(Y ~ X2 + X3)
summary(Reduced_model)

anova(Reduced_model,Full_model)

model <- lm(Y~X2+X3);model
model2 <- lm(Y~X2);model2
modelX2 <- lm(X3~X2);modelX2

y.2 <- resid(model2)
x3.2 <- resid(modelX2)

plot(x3.2,y.2,pch=19,cex=2,xlab="X3|X2",ylab="Y|X2")
model_parX1 <- lm(y.2~x3.2);model_parX1
abline(model_parX1,col="red",lwd=2)

Y_std <- (Y-mean(Y))/sqrt(sum((Y-mean(Y))^2))
X2_std <- (X2-mean(X2))/sqrt(sum((X2-mean(X2))^2))
X3_std <- (X3-mean(X3))/sqrt(sum((X3-mean(X3))^2))

model_std <- lm(Y_std ~ X2_std + X3_std)
summary(model_std)

Y_log <- log(Y)
Y_sqrt <- sqrt(Y)
Y_inv <- 1/Y

par(mfrow=c(2,2))
plot(model)

library(MASS)
par(mfrow=c(1,1))

model_sqrt <- lm(Y_sqrt ~ X2 + X3)
summary(model_sqrt)
par(mfrow=c(2,2))
plot(model_sqrt)

install.packages('car')
library(car)
vif(Reduced_model)

X <- cbind(X2,X3)
R <- cor(X) ;R
round(R,3)

diag(solve(R))

install.packages('leaps')
library(leaps)
df_reg <- df[,c("tooth","smok","ach","diab")]
regfit_too <- regsubsets(x=tooth~.,data=df_reg,method="exhaustive",nbest=3)
summary(regfit_too)

result_regfit <- summary(regfit_too)
result_regfit$adjr2

plot(result_regfit$adjr2,ylim=c(0,1),pch=19,cex=2,ylab="adj_R2",xlab="model",type="b")

final_model_R2 <- lm(Y ~ X2 + X3)
summary(final_model_R2)

null_model_R2 <- lm(Y ~ 1)
anova(final_model_R2,null_model_R2)

2.2e-16 < 0.05

null_model <- lm(Y~1)
step(null_model,scope = ~ X1 + X2 + X3,direction="both",test="F")

influence.measures(Full_model)
cooks.distance(Full_model) # cooks distance
dfbetas(Full_model) # DFBETAS
dffits(Full_model) # DFFITS
covratio(Full_model) # COVRATIO

p <- 4
n <- 1665
cook_standard <- 3.67/(n-p);cook_standard
DFBETAS_standard <- 2/sqrt(n);DFBETAS_standard
DFFITS_standard <- 2*sqrt(p/n);DFFITS_standard
COVRATIO_standard <- 3*p/n; COVRATIO_standard

plot(cooks.distance(Full_model),pch=19,ylab="cooks distance")
abline(h=cook_standard,col="red",lty=2)

par(mfrow=c(2,2))
plot(dfbetas(Full_model)[,1],pch=19,ylab="DFBETAS_1")
abline(h=DFBETAS_standard,col="red",lty=2)
abline(h=-DFBETAS_standard,col="red",lty=2)
plot(dfbetas(Full_model)[,2],pch=19,ylab="DFBETAS_2")
abline(h=DFBETAS_standard,col="red",lty=2)
abline(h=-DFBETAS_standard,col="red",lty=2)
plot(dfbetas(Full_model)[,3],pch=19,ylab="DFBETAS_3")
abline(h=DFBETAS_standard,col="red",lty=2)
abline(h=-DFBETAS_standard,col="red",lty=2)
plot(dfbetas(Full_model)[,4],pch=19,ylab="DFBETAS_4")
abline(h=DFBETAS_standard,col="red",lty=2)
abline(h=-DFBETAS_standard,col="red",lty=2)

par(mfrow=c(1,1))
plot(dffits(Full_model),pch=19,ylab="DFFITS")
abline(h=DFFITS_standard,col="red",lty=2)
abline(h=-DFFITS_standard,col="red",lty=2)

plot(abs(covratio(Full_model)-1),pch=19,ylab="|COVRATIO-1|")
abline(h=COVRATIO_standard,col="red",lty=2)

sum(resid(Full_model)^2)
sum((resid(Full_model) / ( 1 - hatvalues(Full_model)))^2)
resid(Full_model) / ( 1 - hatvalues(Full_model))
