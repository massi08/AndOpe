'use strict';

module.exports = function (grunt) {
    grunt.initConfig({
        // Watch task config
        watch: {
            sass: {
                files: "./scss/*.scss",
                tasks: ['sass']
            }
        },
        // SASS task config
        sass: {
            dev: {
                files: {
                    // destination         // source file
                    "./css/style.css": "./scss/style.scss",
                    "./css/inscription.css": "./scss/inscription.scss",
                    "./css/connexion.css": "./scss/connexion.scss",
                    "./css/code.css": "./scss/code.scss",
                    "./css/manage_project.css": "./scss/manage_project.scss",
                }
            }
        },

        browserSync: {
            default_options: {
                bsFiles: {
                    src: [
                        "css/*.css",
                        "*.html",
                        "js/**"
                    ]
                },
                options: {
                    watchTask: true,
                    server: {
                        baseDir: "./"
                    }
                }
            }
        }
    });

    grunt.loadNpmTasks('grunt-sass');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-browser-sync');
    grunt.registerTask('default', ['browserSync', 'watch']);
};