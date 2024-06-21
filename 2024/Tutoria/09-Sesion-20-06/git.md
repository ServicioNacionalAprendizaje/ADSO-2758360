# Únicamente la priemra vez
git config --global user.name "Jesús González"
git config --global user.email ariel5253@hotmail.com

# Para obtener respositorios públicos
git clone https://github.com/ServicioNacionalAprendizaje/ADSO-2758360.git

# Únicamente obtener cambios
git pull

# Generar cambios en el repositorio. (privilegios)
git pull
git add -A
git commit -m "Mensaje del cambio a realizar"
git push

# Comando para revisar cambios pendientes 
git status