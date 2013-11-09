package com.flagleader.repository;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.StateEdit;
import javax.swing.undo.StateEditable;
import javax.swing.undo.UndoManager;

public class o
  implements j, StateEditable
{
  private transient boolean d = false;
  public static final String a = "RuleEditor";
  protected transient UndoManager b;
  private transient StateEdit e;
  g c = null;

  public o(g paramg)
  {
    this.c = paramg;
  }

  public boolean undo()
  {
    try
    {
      if (canUndo())
        this.b.undo();
      return true;
    }
    catch (CannotUndoException localCannotUndoException)
    {
      System.out.println("Can't undo");
    }
    return false;
  }

  public boolean redo()
  {
    try
    {
      if (canRedo())
        this.b.redo();
      return true;
    }
    catch (CannotRedoException localCannotRedoException)
    {
      System.out.println("Can't redo");
    }
    return false;
  }

  public boolean canUndo()
  {
    if (this.b == null)
      return false;
    return this.b.canUndo();
  }

  public boolean canRedo()
  {
    if (this.b == null)
      return false;
    return this.b.canRedo();
  }

  public void storeState(Hashtable paramHashtable)
  {
    paramHashtable.put("RuleEditor", this.c.copyAllChildren());
  }

  public void restoreState(Hashtable paramHashtable)
  {
    Object localObject = paramHashtable.get("RuleEditor");
    if (localObject != null)
      this.c.replaceAllChildren((List)localObject);
  }

  public void takeSnapshot()
  {
    if (a())
      if (this.b == null)
      {
        initUndoable();
      }
      else
      {
        this.e.end();
        this.b.addEdit(this.e);
        this.e = new StateEdit(this);
      }
  }

  public void initUndoable()
  {
    if (this.b == null)
    {
      this.b = new UndoManager();
      this.e = new StateEdit(this);
    }
  }

  public boolean a()
  {
    return this.d;
  }

  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.o
 * JD-Core Version:    0.6.0
 */