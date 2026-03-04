# 04 — LAYOUT CONTAINERS

## Quale usare in base alla traccia

| Descrizione traccia | Container da usare |
|---|---|
| "elementi uno sotto l'altro" | `VBox` |
| "elementi affiancati" | `HBox` |
| "griglia / tabella" | `GridPane` |
| "finestra con header, footer, centro" | `BorderPane` |
| "posizionamento libero con coordinate" | `AnchorPane` |

---

## VBox

Impila i figli **verticalmente**.

```java
VBox vbox = new VBox();
vbox.setSpacing(10);                        // gap tra elementi
vbox.setPadding(new Insets(10));            // margine interno
vbox.setAlignment(Pos.CENTER);             // allineamento figli
vbox.getChildren().addAll(label, textField, button);
```

In Scene Builder: cerca **VBox** nel pannello Containers, trascinalo sulla canvas.

---

## HBox

Impila i figli **orizzontalmente**.

```java
HBox hbox = new HBox();
hbox.setSpacing(15);
hbox.setPadding(new Insets(10));
hbox.setAlignment(Pos.CENTER_LEFT);
hbox.getChildren().addAll(label, textField);
```

---

## GridPane

Griglia con **righe e colonne**. Ogni elemento ha `col` e `row`.

```java
GridPane grid = new GridPane();
grid.setHgap(10);                          // spazio orizzontale tra celle
grid.setVgap(10);                          // spazio verticale tra celle
grid.setPadding(new Insets(10));
grid.setAlignment(Pos.CENTER);

grid.add(label,     0, 0);                 // (nodo, colonna, riga)
grid.add(textField, 1, 0);
grid.add(button,    0, 1, 2, 1);           // (nodo, col, row, colspan, rowspan)
```

In Scene Builder: seleziona un elemento → tab Layout → imposta Row Index e Column Index.

---

## BorderPane

Divide la finestra in **5 zone**: TOP, BOTTOM, LEFT, RIGHT, CENTER.

```java
BorderPane bp = new BorderPane();
bp.setTop(menuBar);
bp.setCenter(contenutoPrincipale);
bp.setBottom(statusBar);
bp.setLeft(pannelloSinistra);
bp.setRight(pannelloDestra);
```

> È il container root più comune per app con barra di navigazione.
> In Scene Builder si vedono le 5 zone direttamente sulla canvas.

---

## AnchorPane

Posizionamento libero. Gli elementi si aggiungono e si spostano a mano in Scene Builder.
In codice si usano i constraint:

```java
AnchorPane.setTopAnchor(button, 10.0);
AnchorPane.setLeftAnchor(button, 20.0);
```

> Di solito lo usi solo con Scene Builder, non a codice.

---

## Insets — padding e margini

```java
new Insets(10)                // tutti i lati = 10
new Insets(10, 5, 10, 5)      // top, right, bottom, left
```

---

## Pos — allineamenti disponibili

```
Pos.CENTER
Pos.CENTER_LEFT
Pos.CENTER_RIGHT
Pos.TOP_CENTER
Pos.TOP_LEFT
Pos.TOP_RIGHT
Pos.BOTTOM_CENTER
Pos.BOTTOM_LEFT
Pos.BOTTOM_RIGHT
```

Usato con: `vbox.setAlignment(Pos.CENTER)` — funziona uguale per HBox, GridPane.

---

## Annidare i layout (pattern comune)

```java
// Riga con label + input
HBox riga1 = new HBox(10, new Label("Nome:"), textFieldNome);

// Altra riga
HBox riga2 = new HBox(10, new Label("Età:"), textFieldEta);

// Colonna principale
VBox root = new VBox(15, riga1, riga2, buttonConferma);
root.setPadding(new Insets(20));
root.setAlignment(Pos.CENTER);
```

In Scene Builder fai la stessa cosa visivamente trascinando i container dentro altri container.
