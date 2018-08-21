# **20180602**

A sequence diagram:

```{plantuml |}
@startuml
Alice -> Bob: Authentication Request
Bob --> Alice: Authentication Response

Alice -> Bob: Another authentication Request
Alice <-- Bob: another authentication Response
@enduml
```

A dot diagram:


```{dot !}

digraph {
        a -> b[label="0.2",weight="0.2"];
        a -> c[label="0.4",weight="0.4"];
        c -> b[label="0.6",weight="0.6"];
        c -> e[label="0.6",weight="0.6"];
        e -> e[label="0.1",weight="0.1"];
        e -> b[label="0.7",weight="0.7"];
    }

```

**20180821**

I am going to try and make exemd work again.
