module.exports = {
    "presets": [
        "@vue/cli-plugin-babel/preset", ["@babel/preset-env", {
            "useBuiltIns": "entry"
        }]

    ],
    "plugins": [
        [
            "component",
            {
                "libraryName": "element-ui",
                "styleLibraryName": "theme-chalk"
            }
        ]
    ]
}