**20190904**

# Setup Jekyll for The Cat in the Lab blog

https://jekyllrb.com/docs/

## Install a full ruby development environment

https://jekyllrb.com/docs/installation/

### Mac

```bash
xcode-select --install
```

```bash
$ which ruby
/usr/bin/ruby
$ ruby --version
ruby 2.3.7p456 (2018-03-28 revision 63024) [universal.x86_64-darwin18]
```

As is mentioned in the above link

[Jekyll on macOS | Jekyll • Simple, blog-aware, static sites](https://jekyllrb.com/docs/installation/macos/)

> Jekyll requires **Ruby > 2.4.0**. As macOS Mojave 10.14 comes only with ruby 2.3.x, you’ll have to install a newer version of Ruby.

```fish
$ brew upgrade ruby
```

Those instructions also give me an option to use rbenv.

[rbenv/rbenv: Groom your app’s Ruby environment](https://github.com/rbenv/rbenv#how-it-works)

> [](https://github.com/rbenv/rbenv#choosing-the-ruby-version)
> 
> ### Choosing the Ruby Version
> 
> When you execute a shim, rbenv determines which Ruby version to use by reading it from the following sources, in this order:
> 
> 1.  The `RBENV_VERSION` environment variable, if specified. You can use the [`rbenv shell`](https://github.com/rbenv/rbenv#rbenv-shell) command to set this environment variable in your current shell session.
>     
> 2.  The first `.ruby-version` file found by searching the directory of the script you are executing and each of its parent directories until reaching the root of your filesystem.
>     
> 3.  The first `.ruby-version` file found by searching the current working directory and each of its parent directories until reaching the root of your filesystem. You can modify the `.ruby-version` file in the current working directory with the [`rbenv local`](https://github.com/rbenv/rbenv#rbenv-local) command.
>     
> 4.  The global `~/.rbenv/version` file. You can modify this file using the [`rbenv global`](https://github.com/rbenv/rbenv#rbenv-global) command. If the global version file is not present, rbenv assumes you want to use the "system" Ruby—i.e. whatever version would be run if rbenv weren't in your path.

Given rbenv allows me to set ruby version for a specific script/directory and still keep the system one for all other things, this seems like the obvious choice to not break anything else in Mac OS X.

### Install rbenv

```fish
brew install rbenv
```
or, in my case, upgrade it.
```fish
brew upgrade rbenv ruby-build
```

```fish
$ rbenv init
# Load rbenv automatically by appending
# the following to ~/.config/fish/config.fish:

status --is-interactive; and source (rbenv init -|psub)
```
and check it properly works.
```fish
curl -fsSL https://github.com/rbenv/rbenv-installer/raw/master/bin/rbenv-doctor | bash
```
```log
Checking for `rbenv' in PATH: /usr/local/bin/rbenv
Checking for rbenv shims in PATH: OK
Checking `rbenv install' support: /usr/local/bin/rbenv-install (ruby-build 20190828)
Counting installed Ruby versions: 1 versions
Checking RubyGems settings: OK
Auditing installed plugins: OK
```

### Install a version of ruby above 2.4.0 which is a requirement for Jekyll 4.0.0

```fish
rbenv install 2.6.4
```
```log
ruby-build: using openssl from homebrew
Downloading ruby-2.6.4.tar.bz2...
-> https://cache.ruby-lang.org/pub/ruby/2.6/ruby-2.6.4.tar.bz2
Installing ruby-2.6.4...
ruby-build: using readline from homebrew
Installed ruby-2.6.4 to /Users/amartins/.rbenv/versions/2.6.4
```

```fish
rbenv local 2.6.4 # To create a .ruby-version file in the current directory
```

```fish
gem install jekyll bundler
jekyll new myblog
bundle exec jekyll serve
```
and the blog should be running in <http://localhost:4000>.


# Applying Jekyll to The Cat in the Lab blog

Run `jekyll new --force thecatinthelab.github.io` in the directory above the Github pages repository.

Edit the `Gemfile` in the root of `thecatinthelab` repository to use the `github-pages` gem.

```fish
source 'https://rubygems.org'

# Hello! This is where you manage which Jekyll version is used to run.
# When you want to use a different version, change it below, save the
# file and run `bundle install`. Run Jekyll with `bundle exec`, like so:
#
#     bundle exec jekyll serve
#
# This will help ensure the proper Jekyll version is running.
# Happy Jekylling!
# gem "jekyll", "~> 4.0.0"
# This is the default theme for new Jekyll sites. You may change this to anything you like.
# gem "minima", "~> 2.5"
# If you want to use GitHub Pages, remove the "gem "jekyll"" above and
# uncomment the line below. To upgrade, run `bundle update github-pages`.
gem "github-pages", group: :jekyll_plugins
# If you have any plugins, put them here!
# group :jekyll_plugins do
#   gem "jekyll-feed", "~> 0.12"
# end

# Windows and JRuby does not include zoneinfo files, so bundle the tzinfo-data gem
# and associated library.
install_if -> { RUBY_PLATFORM =~ %r!mingw|mswin|java! } do
  gem "tzinfo", "~> 1.2"
  gem "tzinfo-data"
end

# Performance-booster for watching directories on Windows
gem "wdm", "~> 0.1.1", :install_if => Gem.win_platform?

```
as pointed out by https://help.github.com/en/articles/setting-up-your-github-pages-site-locally-with-jekyll#step-2-install-jekyll-using-bundler

The above snippet will make sure we use, locally, the same versions of gems and configurations used by Github Pages.

Hopefully, the above snippet will also help Windows users run Jekyll locally.

Run `bundle update` to update all the necessary dependencies according to the `github-pages` gem.

Finally, run the Jekyll local server.
```fish
 bundle exec jekyll serve
Configuration file: /Users/amartins/github/thecatinthelab/thecatinthelab.github.io/_config.yml
            Source: /Users/amartins/github/thecatinthelab/thecatinthelab.github.io
       Destination: /Users/amartins/github/thecatinthelab/thecatinthelab.github.io/_site
 Incremental build: disabled. Enable with --incremental
      Generating...
       Jekyll Feed: Generating feed for posts
                    done in 0.788 seconds.
 Auto-regeneration: enabled for '/Users/amartins/github/thecatinthelab/thecatinthelab.github.io'
    Server address: http://127.0.0.1:4000/
  Server running... press ctrl-c to stop.
[2019-09-04 19:38:20] ERROR `/favicon.ico' not found.
      Regenerating: 1 file(s) changed at 2019-09-04 19:38:35
                    index.html
       Jekyll Feed: Generating feed for posts
                    ...done in 0.228539 seconds.
```

# Changing the theme.

**20190915**

We have already decided what theme will be used in the first iteration of the Blog - https://github.com/jekyller/jasper2

However, I leave here the features that are important to us:
- Support different authors.
- mathematics - covered by Jekyll as long as the theme supports MathJax.
- list of posts on the left side OR on an easy to navigate page
- comments.

**20200530**





