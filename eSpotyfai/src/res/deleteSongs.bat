@echo off
set FOLDER_PATH=C:\Users\DAM\eclipse-workspace\eSpotyfai\src\tmp_song\

echo Limpiando la carpeta: %FOLDER_PATH%
del /Q "%FOLDER_PATH%*.wav"

echo Carpeta limpiada.