package sait.sll.utility;

import java.io.Serializable;

public class SLL implements LinkedListADT, Serializable
{
	public Node head;
	public Node tail;

	public SLL()
	{
		head = tail = null;
	}

	@Override
	public boolean isEmpty()
	{// david tested
		return head == null;
	}

	@Override
	public void clear()
	{// david tested
		head = null;
		tail = null;
	}

	@Override
	public void append(Object data)
	{//group tested
		if (data != null)
		{
			if (!isEmpty())
			{
				tail.setSuccessor(new Node(data));
				tail = tail.getSuccessor();
			} else
				head = tail = new Node(data);
		}
	}

	@Override
	public void prepend(Object data)
	{//group tested
		if (data != null)
		{
			head = new Node(data, head);
			if (tail == null)
			{
				tail = head;
			}
		}
	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException
	{// raf tested
		if (index >= 0)
		{
			if (index == 0)
			{
				prepend(data);
			} else if (index >= size())
			{
				append(data);
			}

			else
			{
				Node current = head;
				for (int i = 1; i < index; i++)
				{
					current = current.getSuccessor();
				}
				if (current.getSuccessor() != null)
				{
					Node temp = current.getSuccessor();
					current.setSuccessor(new Node(data));
					(current.getSuccessor()).setSuccessor(temp);
				}
			}
		}

	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException
	{// david tested
		if (isEmpty())
		{
			this.append(data);
		}
		Node replace = head;

		try
		{
			for (int i = 0; i < index; i++)
			{
				replace = replace.getSuccessor();
			}
			replace.setElement(data);

			if (replace == null)
			{
				throw new IndexOutOfBoundsException();
			}
		} catch (IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public int size()
	{// raf tested

		int size = 0;
		Node current = head;

		while (current != null)
		{
			size++;
			current = current.getSuccessor();

		}

		return size;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException
	{// saurav tested
		if (index < 0 || index > size() - 1)
			throw new IndexOutOfBoundsException("The specified index is out of bounds.");
		if (index == 0)
			head = head.getSuccessor();
		else
		{
			Node current = head;
			for (int i = 0; i < index - 1; i++)
				current = current.getSuccessor();
			current.setSuccessor(current.getSuccessor().getSuccessor());
		}
		size();

	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException
	{//group tested
		if (isEmpty())
		{
			return null;
		}

		Node current = head;
		Object temp = null;

		try
		{
			for (int i = 0; i < index; i++)
			{
				current = current.getSuccessor();
			}
			temp = current.getElement();

			if (temp == null)
				throw new IndexOutOfBoundsException();
		} catch (IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}

		return temp;
	}

	@Override
	public int indexOf(Object data)
	{// saurav tested
		int index = 0;
		Node current = head;
		while (current != null)
		{
			if (current.getElement().equals(data))
			{
				return index;
			}
			current = current.getSuccessor();
			index++;
		}
		return -1;
	}

	@Override
	public boolean contains(Object data)
	{// saurav tested
		Node current = head;

		while (current != null)
		{
			if (current.getElement().equals(data))
			{
				return true;
			}
			current = current.getSuccessor();
		}
		return false;
	}

}
