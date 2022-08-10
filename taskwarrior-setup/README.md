# Taskwarrior setup

## What is Taskwarrior?

## What is Taskwiki?

## Where do I want to get?

All I want to get to is for tasks to easily sync between my markdown notes from my Vimwiki repository in Markdown and Taskwarrior.
When I say "sync", I actually mean, at a minimum, that I should be able to add and remove, complete and delete tasks in both Taskwiki and a chosen Taskwarrior gui, and see that change reflected in the other.

As an extra "nice to have", Having tasks in Taskwarrior should allow me to also access them from my Android phone and iPadOS devices. But that is for another time/post.

## First attempt worked

Just installing:
 - vimwiki
 - taskwiki
 - taskwarrior (with brew)
was enough to get taskwiki to work.

### How does it work from Vimwiki to TAskwarrior

I only have to add a line with `* [ ] some task description`  and then save the file. These simple actions add a hidden code at the end of the line.
At the same time, a new task gets added to Taskwarrior which I can see appearing, a second later, in any Taskwarrior GUI or TUI. I used ` taskwarrior-tui` to verify this.

When I do changes in Taskwarrior TUI, to make them visible in Vimwiki, I need to call `:TaskWikiLoad` in Vim or Neovim.

### How to organize the tasks in projects

To have some semblance of organization, I have, for now, settled with grouping tasks into projects. 

In Taskwiki, to group tasks into projects, all I have to do is:

1. add a section in the markdown file
2. add ` | project:"Project name"' to the end of that section title (note that, I am using quotes because the project has spaces in it, but if the project name does not have spaces, then the quotes are also unnecessary)
3. add tasks in lines within that section.

With these steps, all tasks will be attributed to the same project.
Note that the ` | project:"Project name" will not be visible unless you enter insert mode in vim by default.

Here is a screenshot of a file within my taskwiki.

TODO - screenshot of vim


And here is a screenshot of the same tasks as viewed in `Taskwarrior-tui`.

TODO - screenshot of taskwarrior-tui
