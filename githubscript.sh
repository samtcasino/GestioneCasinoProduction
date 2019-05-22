cd /var/lib/jenkins/workspace
cd ./GestioneCasino
git remote set-url origin https://github.com/samtcasino/GestioneCasino.git
git pull origin master --allow-unrelated-histories
cd ..
rm ./GestioneCasinoProduction/* -rf
shopt -s extglob
cp !(.*) ./GestioneCasino/code/gestioneCasinoSite/* ./GestioneCasinoProduction/ -rf
cd GestioneCasinoProduction
git remote set-url origin https://github.com/samtcasino/GestioneCasinoProduction.git
git pull origin master --allow-unrelated-histories
git add .
git commit -m "Jenkins commit"
git push

