package com.flagleader.builder.widget;

import java.io.PrintStream;
import java.util.Observable;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.StateEdit;
import javax.swing.undo.StateEditable;
import javax.swing.undo.UndoManager;

public abstract class B extends Observable
  implements StateEditable
{
  public static final String a = "Text";
  public static final String b = "Pos";
  public static final String c = "Loc";
  protected transient UndoManager d;
  private transient StateEdit e;
  private transient boolean f = true;

  protected void a()
  {
    if (this.d == null)
    {
      this.d = new UndoManager();
      this.e = new StateEdit(this);
    }
  }

  public void b()
  {
    if (h())
    {
      if (this.d == null)
      {
        a();
      }
      else
      {
        this.e.end();
        this.d.addEdit(this.e);
        this.e = new StateEdit(this);
      }
      setChanged();
      notifyObservers();
    }
  }

  public boolean c()
  {
    try
    {
      if ((this.d != null) && (this.d.canUndo()))
      {
        a(false);
        this.d.undo();
        setChanged();
        notifyObservers();
        return true;
      }
    }
    catch (CannotUndoException localCannotUndoException)
    {
      System.out.println("Can't undo");
    }
    finally
    {
      a(true);
    }
    a(true);
    return false;
  }

  public boolean e()
  {
    try
    {
      if ((this.d != null) && (this.d.canRedo()))
      {
        a(false);
        this.d.redo();
        setChanged();
        notifyObservers();
        return true;
      }
    }
    catch (CannotRedoException localCannotRedoException)
    {
      System.out.println("Can't redo");
    }
    finally
    {
      a(true);
    }
    a(true);
    return false;
  }

  public boolean f()
  {
    if (this.d == null)
      a();
    return this.d.canUndo();
  }

  public boolean g()
  {
    if (this.d == null)
      a();
    return this.d.canRedo();
  }

  public boolean h()
  {
    return this.f;
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.B
 * JD-Core Version:    0.6.0
 */