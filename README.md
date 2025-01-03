# Jeu Araignée

## 概要

"Jeu Araignée" は、Java で実装された二人対戦型のボードゲームです。プレイヤーは交互に3x3のグリッドに駒を置き、または移動させて、縦・横・斜めのいずれかに3つの駒を揃えることで勝利を目指します。

このゲームは、モジュール化されたコード構造、使いやすいUIデザイン、および魅力的なゲームメカニズムを特徴としています。

## 目次

1. [特徴](#特徴)
2. [始め方](#始め方)
   - [必要要件](#必要要件)
   - [インストール](#インストール)
3. [遊び方](#遊び方)
4. [コード構造](#コード構造)
5. [今後の改善点](#今後の改善点)
6. [謝辞](#謝辞)

---

## 特徴

- **2つのゲームフェーズ**: 
  - **フェーズ1**: プレイヤーが交互に駒を配置。
  - **フェーズ2**: プレイヤーが駒を隣接セルに移動して3つ揃える。
- **インタラクティブなUI**:
  - プレイ、ヘルプ、または終了を選択できるスタート画面。
  - ゲームルールの説明画面。
  - 勝利とリセット画面。
- **動的なデザイン**: Java Swing を使用して構築され、使いやすいインターフェースを実現。
- **堅牢なコード構造**: UIとゲームロジックを分離し、保守性を向上。

---

## 始め方

### 必要要件

- Java Development Kit (JDK) 17 以上
- Java に対応した統合開発環境 (例: IntelliJ IDEA, Eclipse)

### インストール

1. リポジトリをクローンします:
   ```bash
   git clone https://github.com/NaoyaSENOO/SpiderGame.git
   ```
2. プロジェクトディレクトリに移動します:
   ```bash
   cd jeu-araignee
   ```
3. IDEでプロジェクトを開きます。
4. アプリケーションをコンパイルして実行します。

---

## 遊び方

1. アプリケーションを起動します。
2. スタート画面で以下のオプションから選択します:
   - **Start**: ゲームを開始。
   - **Help**: ルールとゲームプレイの説明を表示。
   - **Exit**: アプリケーションを終了。
3. ゲームプレイ:
   - **フェーズ1**: 交互に3つずつ駒を配置します。3つ揃えて勝利を目指します。
   - **フェーズ2**: 勝者が決定しない場合、隣接するセルに駒を移動して3つ揃うまで続行します。
4. 勝利:
   - ゲームが勝者を発表し、リセットまたは終了のオプションを提示します。

---

## コード構造

プロジェクトは読みやすさと保守性を向上させるためにモジュール構造を採用しています:

- **UIクラス**: ユーザーインタラクションとグラフィカルインターフェースを管理。
  - `JFrame` とイベントリスナー (`ActionListener`) を使用して構築。
- **ゲームロジッククラス**: ゲームのルール、状態、およびロジックを管理。
- **コメントとドキュメント**: 各コード部分を説明するインラインコメントを追加。

---

## 今後の改善点

"Jeu Araignée" は完成したプロジェクトですが、以下の改善を追加することが可能です:

- 駒の移動にドラッグ＆ドロップ機能を追加。
- 勝利発表時にアニメーションを追加（例: 揃った駒に線を引く）。
- モダンなコンポーネントを使用してUIデザインを向上。

---

## 謝辞

このプロジェクトは、エコール・サントラル・リヨンのUE PROコースの一環として開発されました。特に **Stéphane Derrode** 教授の指導に感謝します。

---

## 作者

- **Naoya Senoo**
- **Marwane Agrebi**

