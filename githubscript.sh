cd /var/lib/jenkins/workspace
shopt -s extglob
cp !(.*) GestioneCasino/* GestioneCasinoProduction -rf
cd GestioneCasinoProduction
git remote set-url origin https://github.com/samtcasino/GestioneCasinoProduction.git
git pull origin master --allow-unrelated-histories
git add .
git commit -m "Jenkins commit"
git push

